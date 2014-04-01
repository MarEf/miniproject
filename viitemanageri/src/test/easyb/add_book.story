import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*

description 'User can add a book to the list of entries'

scenario "User can add a book to entries", {
    given 'command lisaa selected', {
       io = new StubIO("lisaa", "Matti Meikalainen", "Teoksen Nimi", "Julkaisija", "2014", "Tunnus", "exit")
       appi = new App()
    }

    when 'valid book information is provided', {
       appi.aja(io)
    }

    then 'a book is added to the entries', {
        io.getPrints().shouldHave("Kirja lisätty")
    }
}

