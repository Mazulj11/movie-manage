# Aplikacija za Upravljanje Filmovima

Ovo je Java aplikacija koja omogućuje korisnicima upravljanje kolekcijom filmova. Korisnici mogu dodavati nove filmove, pregledavati postojeće filmove, uređivati i brisati postojeće filmove. Aplikacija koristi MySQL bazu podataka za pohranu podataka i kontejnerizirana je koristeći Docker. Ova aplikacija je napravljena u svrhu kolegija Programiranje u javi na Fakultetu prirodoslovno-matematičkih i odgojnih znanosti  u Mostaru.

### Preduvjeti
Prije nego započnete, osigurajte da imate sljedeće:

- Instaliran Docker i Docker Compose.

- Osnovno razumijevanje Dockera i Docker Composea.

### Početak

Kloniranje Repozitorija

    git clone https://github.com/Mazulj11/movie-manage.git
    cd movie-manage

### Pokretanje Aplikacije

Za izgradnju i pokretanje aplikacije, slijedite ove korake:

1. Izgradnja i Pokretanje Kontejnera:

   `docker-compose up --build`

1. Pristup aplikaciji:

   Otvorite svoj web preglednik i idite na http://localhost za pristup aplikaciji.

1. Zaustavljanje aplikacije:

   Da biste zaustavili aplikaciju, pritisnite CTRL+C u terminalu gdje se docker-compose pokreće.

1. Uklanjanje kontejnera:

   Za uklanjanje kontejnera i povezanih mreža, pokrenite:

   `docker-compose down`

###Inicijalizacija Baze Podataka
Direktorij initdb sadrži SQL skripte koje inicijaliziraju bazu podataka. Ove skripte se automatski pokreću kada se MySQL kontejner pokrene prvi put.

### Funkcionalnosti Aplikacije

Aplikacija pruža sljedeće funkcionalnosti:

1. **Dodavanje Novog Filma:** Omogućuje korisnicima dodavanje novog filma u kolekciju.
1. **Pregled Postojećih Filmova:** Omogućuje korisnicima pregled svih filmova u kolekciji.
1. **Uređivanje Filma:** Omogućuje korisnicima uređivanje detalja postojećeg filma.
1. **Brisanje Filma:** Omogućuje korisnicima brisanje filma iz kolekcije.

### Tehnologije Korištene
- Java (Spring Boot)
- Thymeleaf
- MySQL
- Docker
- Docker Compose


