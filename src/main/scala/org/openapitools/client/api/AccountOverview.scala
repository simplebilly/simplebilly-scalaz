package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AccountOverview._

case class AccountOverview (
  account: String,
accountName: String,
balance: String,
creditTotal: String,
debitTotal: String)

object AccountOverview {
  import DateTimeCodecs._

  implicit val AccountOverviewCodecJson: CodecJson[AccountOverview] = CodecJson.derive[AccountOverview]
  implicit val AccountOverviewDecoder: EntityDecoder[AccountOverview] = jsonOf[AccountOverview]
  implicit val AccountOverviewEncoder: EntityEncoder[AccountOverview] = jsonEncoderOf[AccountOverview]
}
