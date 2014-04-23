import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can view an individual entry in bibtex form'

scenario "User can view an individual entry in bibtex form", {
    given 'command katso selected', {
       new File("viitteet").delete()
       io = new StubIO("lisaa", "3", "John Doe", "b", "c", "2014", "1", "2", "d", "AA1", "katso", "AA1", "exit")
       appi = new App(io, "viitteet")
}
    when 'a valid entry name is given', {
       appi.aja()
}
    then 'entry is shown in bibtex form', {
       io.getPrints().shouldHave("@inproceedings{AA1")
       io.getPrints().shouldHave("author = {John Doe}")
       io.getPrints().shouldHave("publisher = {d}")
       io.getPrints().shouldHave("title = {b}")
       io.getPrints().shouldHave("booktitle = {c}")
       io.getPrints().shouldHave("year = {2014}")
       io.getPrints().shouldHave("publisher = {d}")
}
}