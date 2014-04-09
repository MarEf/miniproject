import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'user can continue to work on another computer'

scenario "User can add a book to entries", {
    given 'command lisaa selected', {
       new File("viitteet").delete();
       io = new StubIO("lisaa", "1", "Matti Meikalainen", "Teoksen Nimi", "Julkaisija", "2014", "Tunnus", "exit")
       appi = new App()
    }

    when 'valid book information is provided', {
       appi.aja(io)
    }

    then 'book is found another application', {
        appi2 = new App()
        io2 = new StubIO("listaa", "exit")

        appi2.aja(io2)
        io2.getPrints().shouldHave("Matti Meikalainen")
    }
}
