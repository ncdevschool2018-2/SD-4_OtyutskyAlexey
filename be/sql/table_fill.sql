INSERT INTO user_account (email, login, password) VALUES ('oleg@tut.by','oleg_user','user');
INSERT INTO user_account (is_admin, email, login, password) VALUES (true, 'pavel@tut.by','pavel_admin','admin');
INSERT INTO user_account (is_admin, email, login, password) VALUES (false, 'sasha@tut.by','sasha_user','user');

INSERT INTO film (name,date_release,description,cost_rent,cost_buy) VALUES
  ('12 Angry Man',
   1957,
   'In a New York City courthouse a jury commences deliberating the case of an 18-year-old boy from a slum, on trial for allegedly stabbing his father to death. If there is any reasonable doubt they are to return a verdict of not guilty. If found guilty, the boy will receive a death sentence.',
  2.99,
  4.99);
INSERT INTO film (name,date_release,description,cost_rent,cost_buy) VALUES
  ('When You''re Strange',
   2009,
   'When You''re Strange is a documentary film about the American rock band the Doors. It is written and directed by Tom DiCillo and for the first time makes material from Jim Morrison''s 1969 film fragment HWY: An American Pastoral publicly available.',
   1.99,
   2.99);
INSERT INTO film (name,date_release,description,cost_rent,cost_buy) VALUES
  ('Once Upon a Time in America',
   1984,
   'Once Upon a Time in America is a 1984 epic crime drama film co-written and directed by Italian filmmaker Sergio Leone and starring Robert De Niro and James Woods. Based on Harry Grey''s novel The Hoods, it chronicles the lives of best friends David "Noodles" Aaronson and Maximilian "Max" Bercovicz as they lead a group of Jewish ghetto youths who rise to prominence as Jewish gangsters in New York City''s world of organized crime. The film explores themes of childhood friendships, love, lust, greed, betrayal, loss, broken relationships, together with the rise of mobsters in American society.',
   3.49,
   6.99);