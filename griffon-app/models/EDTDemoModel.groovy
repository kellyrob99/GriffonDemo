import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.SortedList
import ca.odell.glazedlists.BasicEventList

class EDTDemoModel {
   @Bindable String text

   EventList items = new SortedList( new BasicEventList(), null)
}