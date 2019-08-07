# FCore

FCore is a library of formatting algorithms, specifically used in 3 dimensional spaces. Formats are typically defined by a standard rate of up to 32 frames (starting at 0, and ending at 31). Please see the usage section for more details.

## Installation

```xml
<repository>
    <id>jitpack.io</id>
	<url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.westernpine</groupId>
    <artifactId>Marble</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

## Usage

Using FCore is straight forward. All you need, is the Loc (location) object, and the frame you want to get.
Simplified example:
```Java
List<Loc> formatPart = Formats.RANDOM.getLocs(location, frame);
```
This will return a list of locations for the frame (or part) of the format.

The more complex version of this allows more adjustment and freedom. The Rate is the definition of the format. The many is the count of different locations, or same location returned multiple times. The width will define how wide the format is. This is sometimes used as the height. And the height is how high the format will be, if the width is already used. Refer back to the previous example for the Rate and Frames.
```Java
List<Loc> formatPart = Formats.RANDOM.getLocs(location, rate, many, frame, width, higth);
```

If you have any other questions, comments, or concerns, feel free to contact me here on github or use my website in my profile. Thank you!

License
----

[MIT](https://choosealicense.com/)
