package com.country.buff.helper;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class SpeechletHelper {
	
	public static SpeechletResponse getWelcomeResponse() {
		return getSpeechletResponse("Country Buff", "Welcome to Countty Buff, I can tell you details about a country like its population, currencies, region, languages. Which country do you want to know about?", "Which country do you want to know about?", true);
	}
	
	
	/**
	 * Returns a Speechlet response for a speech and reprompt text.
	 */
	public static SpeechletResponse getSpeechletResponse(String cardTitle, String speechText, String repromptText, boolean isAskResponse) {
		// Create the Simple card content.
		SimpleCard card = new SimpleCard();
		card.setTitle(cardTitle);
		card.setContent(speechText);

		// Create the plain text output.
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		if (isAskResponse) {
			// Create reprompt
			PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
			repromptSpeech.setText(repromptText);
			Reprompt reprompt = new Reprompt();
			reprompt.setOutputSpeech(repromptSpeech);

			return SpeechletResponse.newAskResponse(speech, reprompt, card);

		} else {
			return SpeechletResponse.newTellResponse(speech, card);
		}
	}
}
