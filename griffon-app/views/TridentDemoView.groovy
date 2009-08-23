import org.pushingpixels.trident.Timeline.TimelineState

/**
 * This code is ported from the demo code on aalmiray's blog to work inside a Griffon application.
 */
anim = timeline(model, duration: 4000, loop: 'reverse') {
    interpolatedProperty(property: "s", from: 0.5f, to: 2.0f)
    interpolatedProperty(property: "ra", from: 0f, to: 360f)
}
mouseHandler = {
    anim.state == TimelineState.SUSPENDED ? anim.resume() : anim.suspend()
}

tabbedPane(tabGroup) {
    panel(title: "Trident/Gfx Demo") {
        borderLayout()
        canvas = canvas(preferredSize: [200, 200], constraints: CENTER) {
            group {
                antialias true
                background(color: color("white"))
                group(sx: bind {model.s}, sy: bind {model.s}, ra: bind {model.ra},
                        mouseClicked: mouseHandler) {
                    rect(x: model.cx - model.radius, y: model.cy - model.radius, w: model.radius * 2, h: model.radius * 2, f: color('blue'))
                    circle(cx: model.cx - model.radius, cy: model.cy - model.radius, r: model.radius / 2, f: color('red'))
                    circle(cx: model.cx - model.radius, cy: model.cy + model.radius, r: model.radius / 2, f: color('green'))
                    circle(cx: model.cx + model.radius, cy: model.cy - model.radius, r: model.radius / 2, f: color('yellow'))
                    circle(cx: model.cx + model.radius, cy: model.cy + model.radius, r: model.radius / 2, f: color('violet'))
                }
            }
        }
        label("Click shape to pause/resume", constraints: SOUTH)
        swingRepaintTimeline(canvas, loop: true)
    }
}