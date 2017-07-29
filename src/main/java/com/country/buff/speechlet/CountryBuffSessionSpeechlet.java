package com.country.buff.speechlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;

import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.country.buff.constants.CBConstants;
import com.country.buff.helper.SpeechletHelper;

/**
 * This is the main speechlet that handles the user interaction with the skill.
 * Users can tell alexa about the country they want to know more about and Alexa
 * will then look it up for them. Once the country information is fetched, the
 * user can ask details about the country like - What is the population? - What
 * is the currency? - What is the area?
 * 
 * @author aagnihot
 *
 */
public class CountryBuffSessionSpeechlet implements CBConstants, Speechlet {

	// Getting the logger
	Logger logger = LoggerFactory.getLogger(CountryBuffSessionSpeechlet.class);
	
	
	 /**
     * Used to notify that a new session started as a result of a user interacting with the device.
     * This method enables {@code Speechlet}s to perform initialization logic and allows for session
     * attributes to be stored for subsequent requests.
     *
     * @param request
     *            the session started request
     * @param session
     *            the session associated with the user starting a {@code Speechlet}
     * @throws SpeechletException
     *             for any errors encountered in the processing of the request
     */
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		logger.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(),
                session.getSessionId());
	}

	/**
     * Entry point for {@code Speechlet}s for handling a speech initiated request to start the skill
     * without providing an {@code Intent}.<br>
     *
     * This method is only invoked when {@link Session#isNew()} is {@code true}.
     *
     * @param request
     *            the launch request
     * @param session
     *            the session associated with the request
     * @return the response, spoken and visual, to the request
     * @throws SpeechletException
     *             for any errors encountered in the processing of the request
     */
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		return SpeechletHelper.getWelcomeResponse();
	}

	/**
     * Entry point for handling speech initiated requests.<br>
     *
     * This is where the bulk of the {@code Speechlet} logic lives. Intent requests are handled by
     * this method and return responses to render to the user.<br>
     *
     * If this is the initial request of a new {@code Speechlet} session, {@link Session#isNew()}
     * returns {@code true}. Otherwise, this is a subsequent request within an existing session.
     *
     * @param request
     *            the intent request to handle
     * @param session
     *            the session associated with the request
     * @return the response, spoken and visual, to the request
     * @throws SpeechletException
     *             for any errors encountered in the processing of the request
     */
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		return null;
	}
	
	/**
     * Callback used to notify that the session ended as a result of the user interacting, or not
     * interacting with the device. This method is not invoked if the {@code Speechlet} itself ended
     * the session using {@link SpeechletResponse#setShouldEndSession(boolean)}.
     *
     * @param request
     *            the end of session request
     * @param session
     *            the session associated with the request
     * @throws SpeechletException
     *             for any errors encountered in the processing of the request
     */
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

	}

}
