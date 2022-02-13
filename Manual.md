<h1>Setup</h1>

<h2>Getting dependency</h2>

Import the latest version with <b>Maven</b> using <b>JitPack</b>.
<br><i>(Check JitPack Enterprise for use in private repositories)</i>

<h2>General use</h2>

1. Non-static use:
    * Add FileHandler object to your preferred class.
      <br><i>Multiple FileHandler objects with different values possible.</i>
    * Use `fileHandler.text` for reading/writing text files.
      <br><i>(`EncodingType` enum available at `EncodingUtilities` class.)</i>
    * Use `fileHandler.image` for reading images.
2. Static use:
    * `TextConversion` class.


<h1>Importable/exportable data types</h1>

<h2>Primitives</h2>

Simple data types that extend IEPrimitive class:
* boolean
* int
* float
* double
* string


Usage:
* Use `getValue()` to get its value.
* Check if provided string matches key by `boolean compareKey(String key)`.
* Set value:
    * from imported value array by `parseStringArrayToValue(String[] valueArray)`,
    * manually by `setValue(T value)`.
* Prepare for exporting:
    * only value array: `String[] parseValueToStringArray()`,
    * full separated line: `String[] combineKeyAndValue()`.
* Miscellaneous:
    * reset value: `resetValue()`,
    * gat value array from separated line: `String[] separateValue(String[] line)`.


<h2>Arrays</h2>

* boolean array
* int array
* float array
* double array
* string array

Usage: <i>same as primitives</i>


<h2>Special</h2>
* color <i>(not tested)</i>

Usage: <i>same as primitives</i>


<h2>IE list <i>(not ready yet)</i></h2>

A list for containing AbstractImportableExportable objects.

Usage:
* Refer to `list` parameter to get actual ArrayList of AbstractImportableExportable.
* Call `ArrayList<String[]> exportLines()` to get its members prepared for exporting.
* Set from imported lines by `importLines(ArrayList<String[]> importableLines)`.


<h2>Custom IE object</h2>

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


<h1>Adapters</h1>

<i>Coming soon...</i>