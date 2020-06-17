create table game_record(
  id varchar(64) not null primary key,
  round varchar(64) not null,
  user_guess varchar(7) not null,
  result varchar(4) not null
);