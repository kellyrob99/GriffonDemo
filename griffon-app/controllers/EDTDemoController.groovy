class EDTDemoController {
    // these will be injected by Griffon
    def model
    def view

    def url = 'http://www.dzone.com/links/feed/frontpage/rss.xml'

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }


    def updateText = {evt = null ->
        jxwithWorker(start: true) {
            onInit {
                view.progress.with {
                    setIndeterminate(false)
                    setStringPainted(true)
                    setString("0 %")
                }
            }
            work {
                def feedText = new URL(url).text
                def file = new File('/tmp/tempFeedFile.xml')
                file << feedText
                int max = file.size()
                def buffer = new char[max / 10]
                def text = new StringBuffer()
                file.withReader {reader ->
                    (1..10).each {i ->
                        reader.read(buffer, 0, buffer.size())
                        text.append(buffer)
                        Thread.sleep(300)
                        publish(i * 10)
                    }
                }
                text.toString()
            }
            onUpdate {chunks ->
                view.progress.string = chunks[0] + " %"
                view.progress.value = chunks[0]
            }
            onDone {
                model.text = get()
                view.progress.stringPainted = false
                view.progress.indeterminate = true
            }
        }
    }
}