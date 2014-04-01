import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*

description 'User can create a bibTex-file of all existing entries'

scenario "user can save data to a file in bibTex form", {
    given 'command tallenna selected'
    when 'given file exists'
    then 'data is pushed to the file'
}

scenario "data can not be saved if the target file does not exist", {
    given 'command tallenna selected'
    when 'given file exists'
    then 'data is not pushed to the file'
}

