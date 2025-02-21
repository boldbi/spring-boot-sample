# BoldBI Embedding Spring Boot Sample

This Bold BI Spring Boot sample repository contains the Dashboard embedding sample. This sample demonstrates how to embed the dashboard which is available in your Bold BI server.

## Dashboard view

   ![Dashboard view](/images/dashboard.png)

## Prerequisites

* [Java Development Kit (JDK)](https://www.microsoft.com/openjdk).
* [Visual Studio Code](https://code.visualstudio.com/download).
* [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=pivotal.vscode-boot-dev-pack).

### Supported browsers
  
* Google Chrome, Microsoft Edge, and Mozilla Firefox.

## Configuration

* Please ensure that you have enabled embed authentication on the `Embed Settings` page. If it is not currently enabled, please refer to the following image or detailed [instructions](https://help.boldbi.com/site-administration/embed-settings/#get-embed-secret-code?utm_source=github&utm_medium=backlinks) to enable it.

    ![Embed Settings](/images/enable-embedsecretkey.png)

* To download the `embedConfig.json` file, please follow this [link](https://help.boldbi.com/site-administration/embed-settings/#get-embed-configuration-file?utm_source=github&utm_medium=backlinks) for reference. Additionally, you can refer to the following image for visual guidance.

    ![Embed Settings Download](/images/download-embedsecretkey.png)
    ![EmbedConfig Properties](/images/embedconfig-file.png)

* Copy the downloaded `embedConfig.json` file and paste it into the designated [location](https://github.com/boldbi/spring-boot-sample/tree/master/src/main/resources) within the application. Please ensure that you have placed it in the application as shown in the following image.

   ![EmbedConfig image](/images/embedconfig-location.png)

## Developer IDE

* [Visual Studio Code](https://code.visualstudio.com/download)

### Run a Sample Using Visual Studio Code

* Open the Spring Boot embed sample in the **Visual Studio Code**.

* Now, the run sample using **Spring Boot Dashboard** in the Activity Bar on the side.

    ![spring-boot-dashboard-button](/images/sample-run.png)

* You can access your application by opening a web browser and navigating to the this URL (<http://localhost:8080>).

    ![Dashboard view](/images/dashboard.png)

  Please refer to the [help documentation](https://help.boldbi.com/embedding-options/embedding-sdk/samples/spring-boot/?utm_source=github&utm_medium=backlinks) to know how to run the sample.

## Important notes

It is recommended not to store passwords and sensitive information in configuration files for security reasons in a real-world application. Instead, it would be best if you considered using a secure application, such as Key Vault, to safeguard your credentials.

## Online Demos

Look at the Bold BI Embedding sample to live demo [here](https://samples.boldbi.com/embed?utm_source=github&utm_medium=backlinks).

## Documentation

A complete Bold BI Embedding documentation can be found on [Bold BI Embedding Help](https://help.boldbi.com/embedded-bi/javascript-based/?utm_source=github&utm_medium=backlinks).
