package com.molw.springaiplay.embedding;

import org.springframework.ai.embedding.TransformersEmbeddingClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmbeddingController {

    //TODO get rid of the throws exception
    @GetMapping("/ai/embed")
    public List<List<Double>> makeEmbeddings() throws Exception{
        TransformersEmbeddingClient embeddingClient = new TransformersEmbeddingClient();

        // (optional) defaults to classpath:/onnx/all-MiniLM-L6-v2/tokenizer.json
        //embeddingClient.setTokenizerResource("classpath:/onnx/all-MiniLM-L6-v2/tokenizer.json");
        // (optional) defaults to classpath:/onnx/all-MiniLM-L6-v2/model.onnx
        //embeddingClient.setModelResource("classpath:/onnx/all-MiniLM-L6-v2/model.onnx");

        // (optional) defaults to ${java.io.tmpdir}/spring-ai-onnx-model
        // Only the http/https resources are cached by default.
        //embeddingClient.setResourceCacheDirectory("/tmp/onnx-zoo");

        embeddingClient.afterPropertiesSet();

        List<List<Double>> embeddings =
                embeddingClient.embed(List.of("Hello world", "World is big"));

        return embeddings;
    }

}
