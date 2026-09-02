package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Verfahrensdokumentation._

case class Verfahrensdokumentation (
  entries: List[ComplianceEntry],
generatedAt: String,
title: String,
version: String)

object Verfahrensdokumentation {
  import DateTimeCodecs._

  implicit val VerfahrensdokumentationCodecJson: CodecJson[Verfahrensdokumentation] = CodecJson.derive[Verfahrensdokumentation]
  implicit val VerfahrensdokumentationDecoder: EntityDecoder[Verfahrensdokumentation] = jsonOf[Verfahrensdokumentation]
  implicit val VerfahrensdokumentationEncoder: EntityEncoder[Verfahrensdokumentation] = jsonEncoderOf[Verfahrensdokumentation]
}
