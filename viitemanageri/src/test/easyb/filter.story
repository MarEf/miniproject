import viitemanageri.*
import viitemanageri.io.*
import viitemanageri.logiikka.*
import viitemanageri.viitteet.*
import java.io.File;

description 'User can filter entries'

scenario "User can filter listed entries", {
    given 'option to add filter selected'
    when 'filtering conditions are given'
    then 'command listaa shows filtered entries'
}

scenario "User can remove the filter", {
    given 'option to remove filter selected'
    when 'filter removal done'
    then 'command listaa shows all entries'
}