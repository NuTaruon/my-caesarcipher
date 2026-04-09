package org.example.caesar.model;

public class ProcessingResult {
    private final boolean success;
    private final String massage;
    private final String inputPreview;
    private final String outputPreview;

    public ProcessingResult(boolean success, String massage, String inputPreview, String outputPreview) {
        this.success = success;
        this.massage = massage;
        this.inputPreview = inputPreview;
        this.outputPreview = outputPreview;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMassage() {
        return massage;
    }

    public String getInputPreview() {
        return inputPreview;
    }

    public String getOutputPreview() {
        return outputPreview;
    }
}
