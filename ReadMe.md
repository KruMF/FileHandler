<h1>File Handler</h1>

by [Krumuvecis](https://github.com/Krumuvecis)

Free to use and modify for whatever purposes. No copyrights apply.


<h2>Requirements</h2>

* JDK: 17.0.2
* Maven compiler: 17
* Maven Surefire: 3.0.0-M5
* JUnit: Jupiter 5.8.2


<h2>Instructions</h2>

<h3>General usage</h3>

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


<h3>Importable/exportable data types</h3>

<h4>Simple data types</h4>

Simple data types that extend AbstractImportableExportable class:
* boolean
* int
* float
* string
* string array
* 3-parameter color <i>(RGB)</i>
* 4-parameter color <i>(With alpha, RGBA)</i>

Usage:
* Refer to `value` parameter to get its value.
* Check if provided string matches key by `boolean compareKey(String key)`.
* Set from imported lines by `importLine(String[] importableLine)`.
* Call `String[] exportLine()` to get its key and value prepared for exporting.


<h4>IOlist</h4>

A list for containing AbstractImportableExportable objects.

Usage:
* Refer to `list` parameter to get actual ArrayList of AbstractImportableExportable.
* Call `ArrayList<String[]> exportLines()` to get its members prepared for exporting.
* Set from imported lines by `importLines(ArrayList<String[]> importableLines)`.


<h4>Custom importable/exportable object</h4>

1. Extend `AbstractImportableExportable` class.
2. Add desired `value` parameter.
3. Add unimplemented methods from `ImportableExportableInterface`:
   * `String[] valueArray()` - Parse `value` parameter to `String[]`.
   * `void setValue(String[] valueArray)` - Parse `String[]` to parameter `value`.
5. Add constructor from `super` and add value as parameter.

Usage:
* Refer to `value` parameter to get its value.
* Check if provided string matches key by `boolean compareKey(String key)`.
* Set from imported lines by `importLine(String[] importableLine)`.
* Call `String[] exportLine()` to get its key and value prepared for exporting.

<h2>Notes</h2>

<h3>Supported text encodings</h3>

* Windows-1257 (default)
* UTF-8

Contact [Krumuvecis](https://github.com/Krumuvecis), if more options needed.


<h3>Versioning</h3>


<i>Latest working version available at `master` branch.</i>

<i>Development happening at `develop` branch.</i>