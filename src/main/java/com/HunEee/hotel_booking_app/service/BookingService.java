package com.HunEee.hotel_booking_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HunEee.hotel_booking_app.exception.InvalidBookingRequestException;
import com.HunEee.hotel_booking_app.exception.ResourceNotFoundException;
import com.HunEee.hotel_booking_app.model.BookedRoom;
import com.HunEee.hotel_booking_app.model.Room;
import com.HunEee.hotel_booking_app.repository.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {
	
	private final BookingRepository bookingRepository;
	private final IRoomService roomService;
	
	@Override
	public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
	    return bookingRepository.findByRoomId(roomId);
	}

	@Override
	public List<BookedRoom> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public BookedRoom findByBookingConfirmationCode(String confirmationCode) {
        return bookingRepository.findByBookingConfirmationCode(confirmationCode)
                .orElseThrow(() -> new ResourceNotFoundException(" 찾을 수 없는 예약 코드 :"+confirmationCode));
	}

	@Override
	public String saveBooking(Long roomId, BookedRoom bookingRequest) {
		if (bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())){
		        throw new InvalidBookingRequestException("체크인 날짜는 체크아웃 날짜보다 앞서야 합니다.");
		    }
		    Room room = roomService.getRoomById(roomId).get();
		    List<BookedRoom> existingBookings = room.getBookings();
		    boolean roomIsAvailable = roomIsAvailable(bookingRequest,existingBookings);
		    if (roomIsAvailable){
		        room.addBooking(bookingRequest);
		        bookingRepository.save(bookingRequest);
		    }else{
		        throw  new InvalidBookingRequestException("죄송합니다. 선택한 날짜에는 이용가능한 객실이 없습니다.");
		    }
		    return bookingRequest.getBookingConfirmationCode();
	}
	
	private boolean roomIsAvailable(BookedRoom bookingRequest, List<BookedRoom> existingBookings) {
        return existingBookings.stream()
                .noneMatch(existingBooking ->
                        bookingRequest.getCheckInDate().equals(existingBooking.getCheckInDate())
                                || bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
                                || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate())
                                && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate()))
                                || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

                                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
                                || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

                                && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))

                                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))

                                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                                && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))
                );
	}

	@Override
	public void cancelBooking(Long bookingId) {
		 bookingRepository.deleteById(bookingId);
		
	}
}
