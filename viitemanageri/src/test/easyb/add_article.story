import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can add a book to the list of entries'

scenario "User can add an article to entries", {
    given 'command lisaa and command inproceedings selected', {

       new File("viitteet").delete()
       io = new StubIO("lisaa", "2", "a", "b", "c", "2014", "1", "2", "3", "4", "AA2", "exit")
       appi = new App(io, "viitteet")

    }

    when 'valid inproceedings information is provided', {
        appi.aja()
    }

    then 'a book is added to the entries', {
        io.getPrints().shouldHave("Artikkeli lisätty")
    }
}

