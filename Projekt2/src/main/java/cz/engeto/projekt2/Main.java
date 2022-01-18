package cz.engeto.projekt2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Main {
    List<VATData> vatDataList=new ArrayList<>();

    @GetMapping(value = "/hello")
    public String ahoj(){
        return "ahoj2";
    }
    @GetMapping("/projekt2/test")
    public List<VATData> getVatDataList(){
        return vatDataList;
    }
    @PostMapping("/projekt2/postdata")
    public VATData createDate(@RequestBody VATData vatData){
        vatDataList.add(vatData);
        return vatData;
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        String httpAddress="https://euvatrates.com/rates.json";
        HttpClient httpClient= HttpClient.newBuilder().build();
        HttpRequest httpRequest= HttpRequest.newBuilder().uri(URI.create(httpAddress)).GET().build();
        HttpResponse httpResponse= httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status code"+httpResponse.statusCode());
        String body=httpResponse.body().toString();
        ObjectMapper objectMapper=new ObjectMapper();

        VATData vatData=objectMapper.readValue(body,VATData.class);



//        String body2="{\n" +
//                "            \"country\": \"Austria\",\n" +
//                "            \"standard_rate\": 20.00,\n" +
//                "            \"reduced_rate\": 10.00,\n" +
//                "            \"reduced_rate_alt\": 13.00,\n" +
//                "            \"super_reduced_rate\": false,\n" +
//                "            \"parking_rate\": 12.00\n" +
//                "        }";
//        String body2= vatData.getRates().get("AT");
//        System.out.println(body2);

//        State state=objectMapper.readValue(body2,State.class);
//        System.out.println(state);
        




//        for (Object o:vatData.getRates().values()) {
//            State state1=objectMapper.readValue(o.toString(),State.class);

//            System.out.println(o);
//        }



//        vatData.getRates().entrySet().forEach(stringLongEntry ->{
//                System.out.println(stringLongEntry.getKey()+" --- "
//                        +stringLongEntry.getValue());
//
//        });

    }
}
