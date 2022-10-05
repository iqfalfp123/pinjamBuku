package perpustakaan.pinjamBuku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import perpustakaan.pinjamBuku.DTO.*;
import perpustakaan.pinjamBuku.model.*;
import perpustakaan.pinjamBuku.repository.*;
import perpustakaan.pinjamBuku.service.BukuService;
import perpustakaan.pinjamBuku.service.PeminjamService;
import perpustakaan.pinjamBuku.service.PinjamService;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/api/perpustakaan")
public class PerpustakaanController {
    @Autowired
    PeminjamDb peminjamDb;
    @Autowired
    BukuDb bukuDb;
    @Autowired
    PinjamDb pinjamDb;
    @Autowired
    PeminjamService peminjamService;
    @Autowired
    BukuService bukuService;
    @Autowired
    PinjamService pinjamService;

    @PostMapping(value = "/pinjam-buku/new-data-peminjam")
    private BaseResponse<String> pinjamBukuNewData(
            @Valid @RequestBody PinjamNewDataDTO pinjam,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<String> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                String newPinjam = pinjamService.addPinjamNewPeminjam(pinjam);
                response.setMessage(newPinjam);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PostMapping(value = "/pinjam-buku")
    private BaseResponse<String> pinjamBuku(
            @Valid @RequestBody PinjamDTO pinjam,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<String> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                String newPinjam = pinjamService.addPinjam(pinjam);
                response.setMessage(newPinjam);
//                    response.setResult(newPinjam);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PostMapping(value = "/add-buku")
    private BaseResponse<BukuModel> addBuku(
            @Valid @RequestBody BukuDTO buku,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<BukuModel> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                BukuModel newBuku = bukuService.addBuku(buku);
                response.setMessage("success");
                response.setResult(newBuku);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PostMapping(value = "/add-peminjam")
    private BaseResponse<PeminjamModel> addPeminjam(
            @Valid @RequestBody
            PeminjamDTO peminjam,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<PeminjamModel> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                PeminjamModel newPeminjam = peminjamService.addPeminjam(peminjam);
                response.setMessage("success");
                response.setResult(newPeminjam);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PostMapping(value = "/kembalikan-buku")
    private BaseResponse<String> kembalikanBuku(
            @Valid @RequestBody PinjamDTO pinjam,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<String> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                String kembalikan = pinjamService.kembalikanPinjaman(pinjam);
                response.setMessage(kembalikan);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }

    @PutMapping(value = "/update-data-peminjam")
    private BaseResponse<PeminjamModel> updatePeminjam(
            @Valid @RequestBody
            PeminjamDTO peminjam,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<PeminjamModel> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                PeminjamModel newPeminjam = peminjamService.updatePeminjam(peminjam);
                response.setMessage("success");
                response.setResult(newPeminjam);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }
    @PutMapping(value = "/update-data-buku")
    private BaseResponse<BukuModel> updateBuku(
            @Valid @RequestBody BukuDTO buku,
            BindingResult bindingResult) throws ParseException {
        BaseResponse<BukuModel> response = new BaseResponse<>();
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
        } else {
            try {
                BukuModel newBuku = bukuService.updateBuku(buku);
                response.setMessage("success");
                response.setResult(newBuku);
            } catch (Exception e) {
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
            return response;
        }
    }
}
