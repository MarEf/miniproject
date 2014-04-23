import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can filter entries'

scenario "User can filter listed entries", {
    given 'option to add filter selected', {
       new File("viitteet").delete()
       io = new StubIO("lisaa", "3", "John Doe", "b", "c", "2014", "1", "2", "d", "AA1", "lisaa", "3", "John Doe", "A", "c", "2013", "1", "2", "g", "AB1", "suodatin", "1", "3", "1", "2013", "listaa", "exit")
       appi = new App(io, "viitteet")
}
    when 'filtering conditions are given', {
       appi.aja()
}
    then 'command listaa shows filtered entries', {
       io.getPrints().shouldHave("AB1")
       io.getPrints().shouldNotHave("AA1")
}
}

scenario "User can remove the filter", {
    given 'option to remove filter selected', {
       io = new StubIO("suodatin", "2", "listaa", "exit")
       appi = new App(io, "viitteet")
}
    when 'filter removal done', {
       appi.aja()
}

    then 'command listaa shows all entries', {
       io.getPrints().shouldHave("AB1")
       io.getPrints().shouldHave("AA1")
}
}