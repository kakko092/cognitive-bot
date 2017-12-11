package wfigo.coginitive.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.extern.slf4j.Slf4j;
import wfigo.coginitive.service.SlackWebhookService;

@LineMessageHandler
@Slf4j
public class LineBotController {

	@Autowired
	SlackWebhookService slackService;

	@EventMapping
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		log.info("event: " + event);
		slackService.sendTextMessage(event.getMessage().getText());
		return new TextMessage(event.getMessage().getText());
	}

	@EventMapping
	public void handleDefaultMessageEvent(Event event) {
		log.info("event: " + event);
	}
}