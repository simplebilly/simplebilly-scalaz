package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrainingContent._

case class TrainingContent (
  code: String,
contact: ContactInfo,
passScore: Integer,
quiz: List[QuizQuestion],
sections: List[Section],
title: String,
titleEn: String)

object TrainingContent {
  import DateTimeCodecs._

  implicit val TrainingContentCodecJson: CodecJson[TrainingContent] = CodecJson.derive[TrainingContent]
  implicit val TrainingContentDecoder: EntityDecoder[TrainingContent] = jsonOf[TrainingContent]
  implicit val TrainingContentEncoder: EntityEncoder[TrainingContent] = jsonEncoderOf[TrainingContent]
}
