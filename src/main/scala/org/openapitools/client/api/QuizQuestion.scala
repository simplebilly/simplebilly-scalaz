package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import QuizQuestion._

case class QuizQuestion (
  id: String,
options: List[String],
optionsEn: List[String],
question: String,
questionEn: String)

object QuizQuestion {
  import DateTimeCodecs._

  implicit val QuizQuestionCodecJson: CodecJson[QuizQuestion] = CodecJson.derive[QuizQuestion]
  implicit val QuizQuestionDecoder: EntityDecoder[QuizQuestion] = jsonOf[QuizQuestion]
  implicit val QuizQuestionEncoder: EntityEncoder[QuizQuestion] = jsonEncoderOf[QuizQuestion]
}
