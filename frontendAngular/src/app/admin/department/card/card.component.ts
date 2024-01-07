import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent {
  @Input() imageUrl!: string;
  @Input() altText!: string;
  @Input() name!: string;
  @Input() color!: string;
  @Input() details!: string;
  @Input() deptId!: string;
  
}
