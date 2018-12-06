import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Film} from "../../model/film";

@Injectable({
  providedIn: 'root'
})
// Data service
export class FilmService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for user account data
  getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>('/api/films');
  }

  saveFilm(film: Film): Observable<Film> {
    return this.http.post<Film>('/api/films', film);
  }

  deleteFilm(filmId: string): Observable<void> {
    return this.http.delete<void>('/api/films/' + filmId);
  }

}
