/**
 * Created by Alexey on 13.11.2018.
 */

export class Film {
  id_FILM: string;
  name: string;
  date_release: string;
  description: string;
  cost_rent: string;
  cost_buy: string;

  static cloneBase(film: Film): Film {
    let clonedFilm: Film = new Film();
    clonedFilm.id_FILM = film.id_FILM;
    clonedFilm.name = film.name;
    clonedFilm.date_release = film.date_release;
    clonedFilm.description = film.description;
    clonedFilm.cost_rent = film.cost_rent;
    clonedFilm.cost_buy = film.cost_buy;
    return clonedFilm;
  }
}
