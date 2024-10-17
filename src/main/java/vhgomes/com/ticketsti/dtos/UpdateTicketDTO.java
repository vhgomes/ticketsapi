package vhgomes.com.ticketsti.dtos;

import vhgomes.com.ticketsti.models.Status;

public record UpdateTicketDTO(String title, String description, String category, Long status) {
}
