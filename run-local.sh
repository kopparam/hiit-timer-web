#!/usr/bin/env bash

helm repo add bitnami https://charts.bitnami.com/bitnami

kubectl create namespace springfun

helm upgrade --install appdb bitnami/postgresql \
  --namespace springfun \
  --wait --timeout 1m

export POSTGRES_PASSWORD=$(kubectl get secret --namespace springfun appdb-postgresql -o jsonpath="{.data.postgresql-password}" | base64 --decode)

helm upgrade --install webapp ./helm/springfun \
  --namespace springfun \
  --values ./helm/local.yaml \
  --set env.SPRING_DATASOURCE_PASSWORD=$POSTGRES_PASSWORD \
  --wait --timeout 1m