package com.hotel.lil.learningspring.web;

import com.hotel.lil.learningspring.business.ReservationService;
import com.hotel.lil.learningspring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        List<Guest> guests = this.reservationService.getGuests();
        model.addAttribute("guestsList",guests);
        return "guestsList";
    }
}
