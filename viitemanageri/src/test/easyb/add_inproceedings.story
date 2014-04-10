import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*

description 'User can add a book to the list of entries'

scenario "User can add an inproceedings article to entries", {
    given 'command lisaa and command inproceedings selected', {
       new File("viitteet").delete();
       io = new StubIO("lisaa", "3", "John Doe", "b", "c", "2014", "1", "2", "d", "AA1", "exit")
       appi = new App()
        

    }

    when 'valid inproceedings information is provided', {
        appi.aja(io)
    }

    then 'a book is added to the entries', {
        io.getPrints().shouldHave("Inproceedings lisätty")
    }
}

