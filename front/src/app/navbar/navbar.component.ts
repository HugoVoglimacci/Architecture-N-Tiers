import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {

  public dateObj = new Date();

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public navigationHome(): void {
    this.router.navigate(['mobility-list']);
  }

}
