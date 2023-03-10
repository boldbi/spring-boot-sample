# BoldBI Embedding Spring Boot Sample

This Bold BI Spring Boot sample repository contains the Dashboard embedding sample. This sample demonstrates how to embed the dashboard which is available in your Bold BI server.

This section guides you in using the Bold BI dashboard in your Spring Boot sample application.

 * [Requirements to run the demo](#requirements-to-run-the-demo)
 * [Using the Spring Boot sample](#using-the-spring-boot-sample)
 * [Online Demos](#online-demos)
 * [Documentation](#documentation)
 
 ## Requirements to run the demo

The sample require the following to run:

 * [Java Development Kit (JDK)](https://www.microsoft.com/openjdk).
 * [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
 * [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=pivotal.vscode-boot-dev-pack).
 * [Visual Studio Code](https://code.visualstudio.com/download).

 ## Using the Spring Boot sample
 
 * Open the Spring Boot embed sample in the Visual studio code or any respective IDE. 

 * Open the index.html file in the following location, /src/main/resources/static/index.html.

 * Please change the following properties in the `index.html` file per your Bold BI Server.

    <meta charset="utf-8"/>
    <table>
    <tbody>
        <tr>
            <td align="left">RootUrl</td>
            <td align="left">Dashboard Server URL (Eg: http://localhost:5000/bi, http://demo.boldbi.com/bi).</td>
        </tr>
        <tr>
            <td align="left">SiteIdentifier</td>
            <td align="left">For the Bold BI Enterprise edition, it should be like `site/site1.` For Bold BI Cloud, it should be an empty string.</td>
        </tr>
        <tr>
            <td align="left">Environment</td>
            <td align="left">Your Bold BI application environment. (If Cloud, you should use `cloud,` if Enterprise, you should use `enterprise`).</td>
        </tr>
        <tr>
            <td align="left">dashboardId</td>
            <td align="left">Id of the dashboard you want to embed.</td>
        </tr>


* Now open the `EmbedProperties.java` in the following location,/src/main/java/com/example/demo and provide the following mandatory properties.

		<meta charset="utf-8"/>
		<table>
		<tbody>
        <tr>
            <td align="left">UserEmail</td>
            <td align="left">UserEmail of the Admin in your Bold BI, which will be used to get the dashboard list.</td>
        </tr>
        <tr>
            <td align="left">EmbedSecret</td>
            <td align="left">Get your EmbedSecret key from the Embed tab by enabling the `Enable embed authentication` on the Administration page https://help.boldbi.com/embedded-bi/site-administration/embed-settings/.</td>
        </tr>
		</tbody>
		</table>

* Now run the Spring Boot sample.

<!-- Commanded below line since help documentation is unavailable now -->
<!-- Please refer to the [help documentation]() to know how to run the sample. -->

## Online Demos

Look at the Bold BI Embedding sample to live demo [here](https://samples.boldbi.com/embed).


## Documentation

A complete Bold BI Embedding documentation can be found on [Bold BI Embedding Help](https://help.boldbi.com/embedded-bi/javascript-based/).