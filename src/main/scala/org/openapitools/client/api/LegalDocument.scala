package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LegalDocument._

case class LegalDocument (
  /* Plain text, `\\n\\n` separates paragraphs. */
  content: String,
docType: LegalDocType,
lang: LanguageCode,
title: String)

object LegalDocument {
  import DateTimeCodecs._

  implicit val LegalDocumentCodecJson: CodecJson[LegalDocument] = CodecJson.derive[LegalDocument]
  implicit val LegalDocumentDecoder: EntityDecoder[LegalDocument] = jsonOf[LegalDocument]
  implicit val LegalDocumentEncoder: EntityEncoder[LegalDocument] = jsonEncoderOf[LegalDocument]
}
