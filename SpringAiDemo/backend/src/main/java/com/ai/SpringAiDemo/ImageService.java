package com.ai.SpringAiDemo;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final OpenAiImageModel openAiImageModel;

    public ImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    public ImageResponse generateImage(String prompt) {
        // ImageResponse imageResponse = openAiImageModel.call(
        //     new ImagePrompt(prompt)
        // );

        ImageResponse imageResponse = openAiImageModel.call(
            new ImagePrompt(prompt,
                OpenAiImageOptions.builder()
                    .model("dall-e-2")
                    // .quality("hd")
                    .N(3)
                    .height(512)
                    .width(512).build()
            )
        );

        return imageResponse;
    }

}
