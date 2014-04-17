import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can add a book to the list of entries'

scenario "User can add a book to entries", {
    given 'command lisaa selected', {
       new File("viitteet").delete()
       io = new StubIO("lisaa", "1", "Matti Meikalainen", "Teoksen Nimi", "Julkaisija", "2014", "Tunnus", "exit")
       appi = new App(io, "viitteet")
    }

    when 'valid book information is provided', {
       appi.aja()
    }

    then 'a book is added to the entries', {
        io.getPrints().shouldHave("Kirja lisätty")
    }
}

scenario "User can not add a book to entries twice", {
    given 'command lisaa kirja selected', {
       new File("viitteet").delete();
      io = new StubIO("lisaa", "1", "Matti Meikalainen", "Teoksen Nimi", "Julkaisija", "2014", "Tunnus", "lisaa", "1", "Matti Meikalainen", "Teoksen Nimi", "Julkaisija", "2014", "Tunnus", "Tunnus2", "exit")
      appi = new App(io, "viitteet")
    }

    when 'valid book information is provided', {
      appi.aja()
    }

    then 'a book should not be added to the entries', {
       io.getPrints().shouldHave("Ei uniikki, yritä uudestaan.")
    }
}
