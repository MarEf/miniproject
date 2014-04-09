import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can create a bibTex-file of all existing entries'

scenario "user can save data to a file in bibTex form", {
    given 'command tallenna selected', {
       new File("src/Viiteluettelo").delete()
       io = new StubIO("tallenna", "src", "Viiteluettelo", "exit")
       appi = new App()
    }

    when 'given file exists', {
       appi.aja(io)
    }

    then 'data is pushed to the file', {
       // io.getPrints().shouldHave("Tallennettu")
    }
}


scenario "data can not be saved if the target folder does not exist", {
    given 'command tallenna selected', {
       io = new StubIO("tallenna", "Kansio", "Tiedosto", "exit")
       appi = new App()
    }

    when 'given folder does not exist', {
       appi.aja(io)
    }

    then 'data is not pushed to the file', {
       io.getPrints().shouldHave("Ei onnistunut")
    }
}