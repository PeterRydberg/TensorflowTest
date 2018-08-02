package com.TensorflowTest.TensorflowTest.Serving.Controller;

import com.TensorflowTest.TensorflowTest.Serving.Iris;
import com.TensorflowTest.TensorflowTest.Serving.Service.IrisClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class IrisController {

    @Autowired
    IrisClassifierService irisClassifierService;

    @GetMapping(value = "/iris/classify/class")
    public Iris.IrisType classify(Iris iris, @Valid @RequestParam String modeltype) {

        if (modeltype.equals("tensorflow")){
            return irisClassifierService.classify(iris);
        }
        else if (modeltype.equals("onnx")){
            //System.out.println("ONNX here");

            return irisClassifierService.classify(iris);
        }
        return null;
    }

    @GetMapping(value = "/iris/classify/probabilities")
    public Map<Iris.IrisType, Float> classificationProbabilities(Iris iris) {
        return irisClassifierService.classificationProbabilities(iris);
    }

}