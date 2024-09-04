# BoldBI Embedding Spring Boot Sample

This Bold BI Spring Boot sample repository contains the Dashboard embedding sample. This sample demonstrates how to embed the dashboard which is available in your Bold BI server.

## Dashboard view

   ![Dashboard view](https://github.com/boldbi/vue-with-go-sample/assets/129486688/381aa89c-6870-4489-a744-c3617abc7646)

## Prerequisites

* [Java Development Kit (JDK)](https://www.microsoft.com/openjdk).
* [Visual Studio Code](https://code.visualstudio.com/download).
* [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=pivotal.vscode-boot-dev-pack).

### Supported browsers
  
* Google Chrome, Microsoft Edge, Mozilla Firefox.

## Configuration

* Please ensure that you have enabled embed authentication on the `embed settings` page. If it is not currently enabled, please refer to the following image or detailed [instructions](https://help.boldbi.com/site-administration/embed-settings/#get-embed-secret-code) to enable it.

    ![Embed Settings](https://github.com/boldbi/aspnet-core-sample/assets/91586758/b3a81978-9eb4-42b2-92bb-d1e2735ab007)

* To download the `embedConfig.json` file, please follow this [link](https://help.boldbi.com/site-administration/embed-settings/#get-embed-configuration-file) for reference. Additionally, you can refer to the following image for visual guidance.

    ![Embed Settings Download](https://github.com/boldbi/aspnet-core-sample/assets/91586758/d27d4cfc-6a3e-4c34-975e-f5f22dea6172)
    ![EmbedConfig Properties](https://github.com/boldbi/aspnet-core-sample/assets/91586758/d6ce925a-0d4c-45d2-817e-24d6d59e0d63)

* Copy the downloaded `embedConfig.json` file and paste it into the designated [location](https://github.com/boldbi/spring-boot-sample/tree/master/src/main/resources) within the application. Please ensure that you have placed it in the application as shown in the following image.

   ![EmbedConfig image](https://github.com/boldbi/spring-boot-sample/assets/129486688/944e3064-ffd8-4155-a30a-30994819823c)

## Developer IDE

* [Visual studio code](https://code.visualstudio.com/download)

### Run a Sample Using Visual Studio Code

* Open the Spring Boot embed sample in the **Visual studio code**.

* Now, the run sample using **Spring Boot Dashboard** in the Activity Bar on the side.

    ![spring-boot-dasghboard-button2](https://github.com/boldbi/spring-boot-sample/assets/129486688/50dca4c7-9ad0-45ea-8c8b-6165f297342a)

* You can access your application by opening a web browser and navigating to the this URL (<http://localhost:8080>).

    ![Dashboard view](https://github.com/boldbi/vue-with-go-sample/assets/129486688/381aa89c-6870-4489-a744-c3617abc7646)

  Please refer to the [help documentation](https://help.boldbi.com/embedding-options/embedding-sdk/samples/spring-boot/) to know how to run the sample.

## Important notes

It is recommended not to store passwords and sensitive information in configuration files for security reasons in a real-world application. Instead, it would be best if you considered using a secure application, such as Key Vault, to safeguard your credentials.

## Online Demos

Look at the Bold BI Embedding sample to live demo [here](https://samples.boldbi.com/embed).

## Documentation

A complete Bold BI Embedding documentation can be found on [Bold BI Embedding Help](https://help.boldbi.com/embedded-bi/javascript-based/).
