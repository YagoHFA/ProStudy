package com.planbtech.prostudy.controllers;

import com.planbtech.prostudy.DTO.VideoDTO.VideoCadDTO;
import com.planbtech.prostudy.DTO.VideoDTO.VideoDTO;
import com.planbtech.prostudy.DTO.VideoDTO.VideoFullDTO;
import com.planbtech.prostudy.services.interfaces.IVideoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gerenciamento de vídeos", description = "Gerencia as ações de vídeos")
@RestController
@RequestMapping("/video")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {

    @Autowired
    private IVideoServices iVideoServices;

    @Operation(summary = "Retorna as informações de vídeo", description = "Retorna as informações necessárias para a exibição do vídeo com base no Id da requisição")
    @GetMapping("/find/{id}")
    public ResponseEntity<VideoDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(iVideoServices.findById(id));
    }

    @Operation(summary = "Insere as informações de vídeo", description = "Insere as informações necessárias para a exibição do vídeo")
    @PostMapping("/save")
    public ResponseEntity<Boolean> saveVideo(@RequestBody VideoCadDTO videoDTO){
        try {
            iVideoServices.saveVideo(videoDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Deleta vídeo", description = "Deleta as informações de vídeo")
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteVideo(@RequestBody String id){
        try {
            iVideoServices.deleteVideo(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    @Operation(summary = "Atualiza as informações de vídeo", description = "Atualiza as informações de exibição do vídeo")
    public ResponseEntity<Boolean> updateVideo(@RequestBody VideoFullDTO videoDTO){
        try {
            iVideoServices.updateVideo(videoDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
