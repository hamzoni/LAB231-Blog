
package Entities;

import java.io.Serializable;

public class About implements Serializable {
    private String signature;
    private String content;

    public About() {
        sample();
    }
    
    private void sample() {
        this.signature = "Ta Quy";
        this.content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque tellus neque, malesuada nec augue id, imperdiet sollicitudin erat. Quisque laoreet pharetra dolor, nec dapibus nisl molestie et. Nam rhoncus varius tortor. Sed sagittis tincidunt augue non molestie. Curabitur tristique lectus ac malesuada tempus. Mauris tristique arcu non mi dictum porttitor. Ut luctus enim tortor, sit amet facilisis arcu pharetra vel. Nam a ante mauris. Duis dolor lacus, accumsan id euismod eu, sagittis ut purus. Proin ut ante euismod tellus dictum mollis et ac nulla. \n" +
        "\n Nullam blandit urna aliquam, congue odio maximus, tempus metus. Aenean sed metus nibh. Donec gravida augue ipsum, ut dictum lectus porta eget. Sed eu tempus magna. Suspendisse potenti. Sed lacinia odio quis ex interdum, dictum luctus nisl euismod. Curabitur non lacinia augue. Praesent felis massa, condimentum sit amet leo at, lobortis dignissim massa. Morbi eu sem magna.";
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
