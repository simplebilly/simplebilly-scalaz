package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PublicPosting._

case class PublicPosting (
  currency: Option[String],
description: String,
employmentType: Option[String],
id: UUID,
location: Option[String],
remote: Boolean,
requiredSkills: List[String],
requirements: Option[String],
salaryMax: Option[Integer],
salaryMin: Option[Integer],
title: String)

object PublicPosting {
  import DateTimeCodecs._

  implicit val PublicPostingCodecJson: CodecJson[PublicPosting] = CodecJson.derive[PublicPosting]
  implicit val PublicPostingDecoder: EntityDecoder[PublicPosting] = jsonOf[PublicPosting]
  implicit val PublicPostingEncoder: EntityEncoder[PublicPosting] = jsonEncoderOf[PublicPosting]
}
