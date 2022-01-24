<h1>File Handler</h1>

by [Krumuvecis](https://github.com/Krumuvecis)

Free to use and modify for whatever purposes. No copyrights apply.


<h2>Requirements</h2>

* JDK: 17.0.2
* Maven compiler: 17
* Maven Surefire: 3.0.0-M5
* JUnit: Jupiter 5.8.2


<h2>Instructions</h2>

1. Import the latest version with <b>Maven</b> using <b>JitPack</b>.
<br><i>(Check JitPack Enterprise for use in private repositories)</i>
2. Non-static use:
   * Add FileHandler object to your preferred class.
   <br><i>Multiple FileHandler objects with different values possible.</i>
   * Use `fileHandler.text` for reading/writing text files.
   <br><i>(`EncodingType` enum available at `EncodingUtilities` class.)</i>
   * Use `fileHandler.image` for reading images.
3. Static use:
   * `TextConversion` class.


<h2>Notes</h2>


<h3>Supported text encodings</h3>

* Windows-1257 (default)
* UTF-8

Contact [Krumuvecis](https://github.com/Krumuvecis), if more options needed.


<h3>Versioning</h3>


<i>Latest working version available at `master` branch.</i>

<i>Development happening at `develop` branch.</i>