/**
 * Created by Alexey on 13.11.2018.
 */

import {Component, OnInit, TemplateRef} from "@angular/core";
import {Film} from "../../model/film"
import {FilmService} from "../../service/film/film.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})

export class FilmsComponent implements OnInit{

  public editMode = false;

  public films: Film[];
  public editableBa: Film = new Film();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];


  constructor(private filmService: FilmService,
              private loadingService: Ng4LoadingSpinnerService,
              private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  }

  ngOnInit(){
    this.loadFilms();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, film: Film): void {

    if (film) {
      this.editMode = true;
      this.editableBa = Film.cloneBase(film);
    } else {
      //this.refreshBa();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _addFilm(): void {
    this.loadingService.show();
    this.subscriptions.push(this.filmService.saveFilm(this.editableBa).subscribe(() => {
      this._updateFilms();
      this._closeModal();
      this.loadingService.hide();

    }));
  }

  public _updateFilms(): void {
    this.loadFilms();
  }

  public _deleteFilm(filmId: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.filmService.deleteFilm(filmId).subscribe(() => {
      this._updateFilms();
    }));
  }

  private loadFilms(): void {
    this.loadingService.show();
    // Get data from FilmService
    this.subscriptions.push(this.filmService.getFilms().subscribe(films => {
      // Parse json response into local array
      this.films = films as Film[];
      // Check data in console
      console.log(this.films);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
