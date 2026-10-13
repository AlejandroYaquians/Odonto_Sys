import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { Servicio } from '../../core/models/catalogo.models';
import { LineaServicio } from '../../core/models/cobro.models';

@Component({
  selector: 'app-servicios-cobro',
  imports: [DecimalPipe],
  templateUrl: './servicios-cobro.component.html',
  styleUrl: './servicios-cobro.component.scss'
})
export class ServiciosCobroComponent {
  @Input() servicios: Servicio[] = [];
  @Input() lineas: LineaServicio[] = [];
  @Input() mostrarErrores = false;
  @Output() lineasCambio = new EventEmitter<LineaServicio[]>();

  get total(): number {
    return this.lineas.reduce((suma, linea) => suma + (linea.precio || 0), 0);
  }

  agregar(): void {
    this.lineasCambio.emit([...this.lineas, { idServicio: null, precio: 0 }]);
  }

  quitar(indice: number): void {
    this.lineasCambio.emit(this.lineas.filter((_, i) => i !== indice));
  }

  cambiarServicio(indice: number, valor: string): void {
    const idServicio = valor === '' ? null : Number(valor);
    const servicio = this.servicios.find((s) => s.idServicio === idServicio);
    this.lineasCambio.emit(
      this.lineas.map((linea, i) =>
        i === indice ? { idServicio, precio: servicio ? servicio.costoBase : linea.precio } : linea
      )
    );
  }

  cambiarPrecio(indice: number, valor: string): void {
    const precio = valor === '' ? 0 : Number(valor);
    this.lineasCambio.emit(this.lineas.map((linea, i) => (i === indice ? { ...linea, precio } : linea)));
  }

  precioInvalido(linea: LineaServicio): boolean {
    return linea.precio < 0 || Number.isNaN(linea.precio);
  }
}
