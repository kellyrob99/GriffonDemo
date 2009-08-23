import org.fest.swing.fixture.*
import org.testng.annotations.*
import griffon.application.SingleFrameApplication
import griffon.util.GriffonApplicationHelper
import org.testng.Assert

class BindingDemoTest {
    private SingleFrameApplication app
    private FrameFixture window

    static {
        SingleFrameApplication.metaClass.shutdown = {->
            GriffonApplicationHelper.runScriptInsideEDT("Shutdown", delegate)
            delegate.appFrames[0].visible = false
        }
    }

    @BeforeMethod
    void init() {
        app = new SingleFrameApplication()
        app.bootstrap()
        app.realize()
        window = new FrameFixture(app.appFrames[0])
        window.show()
    }

    @AfterMethod
    void cleanup() {
        window.cleanUp()
    }

    // --== tests ==--

    @Test
    void testBinding() {
        def text = 'My new text'
        window.menuItemWithPath('Demo', 'Binding').click()
        window.textBox('bindingField').setText(text)

        Assert.assertEquals(window.label('bindingLabel').text(), text)
        
        def model = app.models.find{it.toString().contains('BindingDemo')}.value
        Assert.assertEquals(model.text, text)
    }
}