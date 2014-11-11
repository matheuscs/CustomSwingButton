# Custom Button for Swing

In this application I made a very simple way to customize the buttons for Java Swing.

Actually, I used a JLabel with a picture and overrode the mousePressed(), mouseReleased() and mouseMoved() events, simulating a button behavior.

The picture can be of any shape, once the override events know whether the mouse is hovering a transparent or an opaque pixel.

As an example, I made three different images that represents the three button states:

* Regular;
* Hovering; and
* Clicking.

When clicked, the button prints a text in the console, confirming the button-like behavior.

## Limitations

The JLabel button-like presents a limitation when the mouse is fastly moved out of it or when ALT+TAB is pressed and the mouse was hovering the JLabel, both actions make the JLabel image not update to the regular (not-hovering nor clicking) image.

### Possible solution

By now, there is a verification that checks if the mouse is no longer hovering an opaque pixel, if so the image is updated from the hovering picture to the regular one, but this verification just ocurrs if the mouse is hovering the JLabel, it doesn't happen if the mouse is hovering the JFrame for example.

Additionally to the existing verification, it could have another, made by a thread that would check whether the mouse is still hovering the image or not. Though, I'm not sure if it is an overhead, I didn't implement this because I believe that there are better ways to do so.

## Final considerations

I developed this code to answer [this question][1] in "Stack Overflow em Português" and afterwards I decided to upload the whole project to GitHub so I can attach the repository link to the answer and make it easier to donwload and test, as soon as it is a Swing application with external resources the bare code isn't of much help, and probably nobody would download image by image along with the code to reassemble the project in the computer to test it.

[1]: http://pt.stackoverflow.com/q/15490/3117