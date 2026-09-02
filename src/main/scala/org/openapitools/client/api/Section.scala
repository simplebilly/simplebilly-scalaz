package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Section._

case class Section (
  bodyHtml: String,
bodyHtmlEn: String,
id: String,
title: String,
titleEn: String)

object Section {
  import DateTimeCodecs._

  implicit val SectionCodecJson: CodecJson[Section] = CodecJson.derive[Section]
  implicit val SectionDecoder: EntityDecoder[Section] = jsonOf[Section]
  implicit val SectionEncoder: EntityEncoder[Section] = jsonEncoderOf[Section]
}
